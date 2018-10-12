package com.traum.code;

import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.NullCacheStorage;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import java.io.IOException;

/**
 * FreeMarker 工具类
 */
public class FreeMarkerTemplateUtils {

    /**
     *
     */
    private static final Configuration CONFIGURATION = new Configuration(Configuration.VERSION_2_3_22);

    /**
     * 构造方法
     */
    private FreeMarkerTemplateUtils(){

    }

    static{
        //这里比较重要，用来指定加载模板所在的路径
        CONFIGURATION.setTemplateLoader(new ClassTemplateLoader(FreeMarkerTemplateUtils.class, "/templates"));
        CONFIGURATION.setDefaultEncoding("UTF-8");
        CONFIGURATION.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        CONFIGURATION.setCacheStorage(NullCacheStorage.INSTANCE);
    }

    /**
     * 获取Template类
     * @param templateName
     * @return
     * @throws IOException
     */
    public static Template getTemplate(String templateName) throws IOException {
        try {
            return CONFIGURATION.getTemplate(templateName);
        } catch (IOException e) {
            throw e;
        }
    }


    public static void clearCache() {
        CONFIGURATION.clearTemplateCache();
    }

}
