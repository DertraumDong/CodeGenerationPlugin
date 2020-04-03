package com.traum.code;

import freemarker.template.Template;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

/**
 * 代码生成工具
 * 例：
 * com.traum.code.GenerationUtil generationUtil = new com.traum.code.GenerationUtil("sku","com.cn.demo","/com/cn/demo","商品","G:/demo/");
 * generationUtil.generate();
 * @Author DerTraum
 * @Date 2018年10月11日 17:00
 * @Version 1.0
 */
public class GenerationUtil {

    /**
     * AUTHOR：作者
     */
    private static String AUTHOR = System.getenv().get("USERNAME");

    /**
     * CURRENT_DATE：创建日期
     */
    private static String CURRENT_DATE = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());

    /**
     * tableName：数据库表名
     */
    private static String tableName ;

    /**
     * packageName：需要生成的代码所在包名
     * 例子：com.cn.demo
     */
    private static String packageName ;

    /**
     * packageNamePath：所在文件路径名
     * 例子：/com/cn/demo
     */
    private static String packageNamePath ;

    /**
     * tableAnnotation：生成代码的类注释
     */
    private static String tableAnnotation ;

    /**
     * URL：数据库连接地址
     */
    private static String URL ;

    /**
     * USER：数据库账户
     */
    private static String USER ;

    /**
     * PASSWORD：数据库账号对应密码
     */
    private static String PASSWORD ;

    /**
     * DRIVER：数据库加载类
     */
    private static String DRIVER ;

    /**
     * diskPath：代码生成保存路径
     */
    private static String diskPath ;

    /**
     * changeTableName
     */
    private String changeTableName ;

    /**
     * 本次表的主键名称
     */
    private String primaryKey;

    /**
     * 无参构造方法
     */
    private GenerationUtil() {
    }

    /**
     * 工具类初始化方法（完整方法）
     * @param AUTHOR 作者
     * @param CURRENT_DATE 创建日期
     * @param tableName 数据库表名
     * @param packageName 需要生成的代码所在包名
     * @param packageNamePath 所在文件路径名
     * @param tableAnnotation 生成代码的类注释
     * @param URL 数据库连接地址
     * @param USER 数据库账户
     * @param PASSWORD 数据库账号对应密码
     * @param DRIVER 数据库加载类
     * @param diskPath 代码生成保存路径
     * @return generationUtil
     */
    public static GenerationUtil init(String AUTHOR, String CURRENT_DATE, String tableName, String packageName, String packageNamePath, String tableAnnotation, String URL, String USER, String PASSWORD, String DRIVER, String diskPath) {
        GenerationUtil generationUtil = new GenerationUtil();
        generationUtil.AUTHOR = AUTHOR;
        generationUtil.CURRENT_DATE = CURRENT_DATE;
        generationUtil.tableName = tableName;
        generationUtil.packageName = packageName;
        generationUtil.packageNamePath = packageNamePath;
        generationUtil.tableAnnotation = tableAnnotation;
        generationUtil.URL = URL;
        generationUtil.USER = USER;
        generationUtil.PASSWORD = PASSWORD;
        generationUtil.DRIVER = DRIVER;
        generationUtil.diskPath = diskPath;
        generationUtil.changeTableName = replaceUnderLineAndUpperCase(tableName);
        return generationUtil;
    }

    /**
     * 工具类初始化方法（缺省方法）
     * @param tableName 数据库表名
     * @param packageName 需要生成的代码所在包名
     * @param packageNamePath 所在文件路径名
     * @param tableAnnotation 生成代码的类注释
     * @param URL 数据库连接地址
     * @param USER 数据库账户
     * @param PASSWORD 数据库账号对应密码
     * @param DRIVER 数据库加载类
     * @param diskPath 代码生成保存路径
     * @return
     */
    public static GenerationUtil init(String tableName, String packageName, String packageNamePath, String tableAnnotation, String URL, String USER, String PASSWORD, String DRIVER, String diskPath) {
        GenerationUtil generationUtil = new GenerationUtil();
        generationUtil.tableName = tableName;
        generationUtil.packageName = packageName;
        generationUtil.packageNamePath = packageNamePath;
        generationUtil.tableAnnotation = tableAnnotation;
        generationUtil.URL = URL;
        generationUtil.USER = USER;
        generationUtil.PASSWORD = PASSWORD;
        generationUtil.DRIVER = DRIVER;
        generationUtil.diskPath = diskPath;
        generationUtil.changeTableName = replaceUnderLineAndUpperCase(tableName);
        return generationUtil;
    }

    /**
     * 创建数据库连接
     * @return
     * @throws Exception
     */
    private Connection getConnection() throws Exception{
        Class.forName(DRIVER);
        Connection connection= DriverManager.getConnection(URL, USER, PASSWORD);
        return connection;
    }

    /**
     * 创建文件夹路径
     * @param path
     */
    private void createPackageMkdir(String path){
        File file = new File(path);
        file.mkdirs();
    }

    /**
     * 生成方法
     * @throws Exception
     */
    public void generate() throws Exception{
        diskPath = diskPath + packageNamePath;
        createPackageMkdir(diskPath);
        try {
            Connection connection = getConnection();
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            ResultSet keysSet = databaseMetaData.getPrimaryKeys(null,null,tableName);
            while(keysSet.next()){
                String primaryName = keysSet.getString("COLUMN_NAME");
                primaryKey = primaryName;
            }
            ResultSet resultSet = databaseMetaData.getColumns(null,"%", tableName,"%");
            //生成Mapper文件
            generateMapperFile(resultSet);
            //生成Dao文件
            generateDaoFile(resultSet);
            //生成Repository文件
            //generateRepositoryFile(resultSet);
            //生成Controller层文件
            generateControllerFile(resultSet);
            //生成服务层接口文件
            generateServiceInterfaceFile(resultSet);
            //生成服务实现层文件
            generateServiceImplFile(resultSet);
            //生成DTO文件
            generateDTOFile(resultSet);
            //生成Model文件
            ResultSet resultSet1 = databaseMetaData.getColumns(null,"%", tableName,"%");
            generateModelFile(resultSet1);
            //生成ResultData文件
            generateResultData(resultSet);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally{

        }
    }

    /**
     * 生成Model
     * @param resultSet
     * @throws Exception
     */
    private void generateModelFile(ResultSet resultSet) throws Exception{
        String packageNamePath = "/model/";
        String suffix = ".java";
        String path = diskPath + packageNamePath ;
        createPackageMkdir(path);
        path += changeTableName + suffix;
        final String templateName = "Model.ftl";
        File mapperFile = new File(path);
        List<ColumnClass> columnClassList = new ArrayList<ColumnClass>();

        while(resultSet.next()){
            ColumnClass columnClass = new ColumnClass();
            String columnName = resultSet.getString("COLUMN_NAME");
            String columnType = resultSet.getString("TYPE_NAME").toLowerCase();
            String columnRemark = resultSet.getString("REMARKS");
            int len = resultSet.getInt("COLUMN_SIZE");
            int precision = resultSet.getInt("DECIMAL_DIGITS");
            if (columnName == null || "".equals(columnName)) {
                continue;
            }
            columnClass.setColumnName(columnName);
            columnClass.setColumnType(columnType);
            columnClass.setColumnComment(columnRemark);
            columnClass.setChangeColumnName(columnName);
            columnClassList.add(columnClass);
        }
        Map<String,Object> dataMap = new HashMap<String,Object>();
        dataMap.put("model_column",columnClassList);
        generateFileByTemplate(templateName,mapperFile,dataMap);

    }

    /**
     * 生成DTO
     * @param resultSet
     * @throws Exception
     */
    private void generateDTOFile(ResultSet resultSet) throws Exception{
        final String packageNamePath = "/model/";
        final String suffix = "DTO.java";
        String path = diskPath + packageNamePath ;
        createPackageMkdir(path);
        path += changeTableName + suffix;
        final String templateName = "DTO.ftl";
        File mapperFile = new File(path);
        Map<String,Object> dataMap = new HashMap<String,Object>();
        generateFileByTemplate(templateName,mapperFile,dataMap);
    }

    /**
     * 生成ResultData
     * @param resultSet
     * @throws Exception
     */
    private void generateResultData(ResultSet resultSet) throws Exception{
        final String packageNamePath = "/model/";
        final String suffix = "ResultData.java";
        String path = diskPath + packageNamePath;
        createPackageMkdir(path);
        path += suffix;
        final String templateName = "ResultData.ftl";
        File mapperFile = new File(path);
        Map<String,Object> dataMap = new HashMap<String,Object>();
        generateFileByTemplate(templateName,mapperFile,dataMap);

    }

    /**
     * 生成controller
     * @param resultSet
     * @throws Exception
     */
    private void generateControllerFile(ResultSet resultSet) throws Exception{
        final String packageNamePath = "/controller/";
        final String suffix = "Controller.java";
        String path = diskPath + packageNamePath;
        createPackageMkdir(path);
        path += changeTableName + suffix;
        final String templateName = "Controller.ftl";
        File mapperFile = new File(path);
        Map<String,Object> dataMap = new HashMap<String,Object>();
        generateFileByTemplate(templateName,mapperFile,dataMap);
    }

    /**
     * 生成service接口类
     * @param resultSet
     * @throws Exception
     */
    private void generateServiceInterfaceFile(ResultSet resultSet) throws Exception{
        final String packageNamePath = "/service/";
        final String prefix = "I";
        final String suffix = "Service.java";
        String path = diskPath + packageNamePath ;
        createPackageMkdir(path);
        path += prefix + changeTableName + suffix;
        final String templateName = "InterfaceService.ftl";
        File mapperFile = new File(path);
        Map<String,Object> dataMap = new HashMap<String,Object>();
        generateFileByTemplate(templateName,mapperFile,dataMap);
    }

    /**
     * 生成service实现类
     * @param resultSet
     * @throws Exception
     */
    private void generateServiceImplFile(ResultSet resultSet) throws Exception{
        final String packageNamePath = "/service/impl/";
        final String suffix = "ServiceImpl.java";
        String path = diskPath + packageNamePath ;
        createPackageMkdir(path);
        path += changeTableName + suffix;
        final String templateName = "InterfaceServiceImpl.ftl";
        File mapperFile = new File(path);
        Map<String,Object> dataMap = new HashMap<String,Object>();
        generateFileByTemplate(templateName,mapperFile,dataMap);
    }


/*
    private void generateRepositoryFile(ResultSet resultSet) throws Exception{
        final String packageNamePath = "/repository/";
        final String suffix = "Repository.java";
        String path =  diskPath + packageNamePath;
        createPackageMkdir(path);
        path += changeTableName + suffix;
        final String templateName = "Repository.ftl";
        File mapperFile = new File(path);
        Map<String,Object> dataMap = new HashMap<String,Object>();
        generateFileByTemplate(templateName,mapperFile,dataMap);
    }
*/

    /**
     * 生成DAO
     * @param resultSet
     * @throws Exception
     */
    private void generateDaoFile(ResultSet resultSet) throws Exception{
        final String packageNamePath = "/dao/";
        final String suffix = "DAO.java";
        String path = diskPath + packageNamePath;
        createPackageMkdir(path);
        path += changeTableName + suffix;
        final String templateName = "Dao.ftl";
        File mapperFile = new File(path);
        Map<String,Object> dataMap = new HashMap<String,Object>();
        generateFileByTemplate(templateName,mapperFile,dataMap);

    }

    /**
     * 生成Mapper
     * @param resultSet
     * @throws Exception
     */
    private void generateMapperFile(ResultSet resultSet) throws Exception{
        final String packageNamePath = "/mapper/";
        final String suffix = "Mapper.xml";
        String path = diskPath + packageNamePath;
        createPackageMkdir(path);
        path += changeTableName + suffix;
        final String templateName = "Mapper.ftl";
        List<ColumnClass> columnClassList = new ArrayList<ColumnClass>();

        ColumnClass column = null;
        while(resultSet.next()){
            column = new ColumnClass();
            String columnName = resultSet.getString("COLUMN_NAME");
            String type = resultSet.getString("DATA_TYPE");
            Integer t = Integer.valueOf(type);
            String columnType = JdbcTypeData.typeToName(t);
            //String columnType = resultSet.getString("TYPE_NAME");//.toLowerCase()
            //JdbcTypeData.format(JdbcTypeData.stringForInteger(columnType));
            String columnRemark = resultSet.getString("REMARKS");
            int len = resultSet.getInt("COLUMN_SIZE");
            int precision = resultSet.getInt("DECIMAL_DIGITS");
            if (columnName == null || "".equals(columnName)) {
                continue;
            }
            column.setColumnName(columnName);
            column.setColumnType(columnType);
            column.setColumnComment(columnRemark);
            column.setChangeColumnName(columnName);
            if(columnName.equals(primaryKey)){
                column.setIsKey(1);
            }else{
                column.setIsKey(0);
            }
            columnClassList.add(column);
        }
        File mapperFile = new File(path);
        Map<String,Object> dataMap = new HashMap<String,Object>();
        dataMap.put("model_column",columnClassList);
        generateFileByTemplate(templateName,mapperFile,dataMap);

    }

    /**
     * FreeMarker执行模板生成文件方法
     * @param templateName
     * @param file
     * @param dataMap
     * @throws Exception
     */
    private void generateFileByTemplate(final String templateName,File file,Map<String,Object> dataMap) throws Exception{
        Template template = FreeMarkerTemplateUtils.getTemplate(templateName);
        FileOutputStream fos = new FileOutputStream(file);
        dataMap.put("table_name_small",tableName);
        dataMap.put("table_name",changeTableName);
        dataMap.put("author",AUTHOR);
        dataMap.put("date",CURRENT_DATE);
        dataMap.put("package_name",packageName);
        dataMap.put("table_annotation",tableAnnotation);
        Writer out = new BufferedWriter(new OutputStreamWriter(fos, "utf-8"),10240);
        template.process(dataMap,out);
    }


    /**
     *
     * @param str
     * @return
     */
    private static String replaceUnderLineAndUpperCase(String str){
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        int count = sb.indexOf("_");
        while(count!=0){
            int num = sb.indexOf("_",count);
            count = num + 1;
            if(num != -1){
                char ss = sb.charAt(count);
                char ia = (char) (ss - 32);
                sb.replace(count , count + 1,ia + "");
            }
        }
        String result = sb.toString().replaceAll("_","");
        return StringUtils.capitalize(result);
    }

}
