package com.kevin.xing.index;

import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        try{

            System.out.println(" == ");
            Class<?> clazz = Class.forName("com.kevin.xing.enums.AqjdEnums");

            Method[] methods = clazz.getMethods();
//            for (Method m : methods) {
//                System.out.println("method = " + m.getName());
//            }

            Class<?>[] classes = clazz.getClasses();

            for (Class cla : classes) {
                Object[] enumConstants = cla.getEnumConstants();

                System.out.println(enumConstants);
            }

            Object[] obj = clazz.getEnumConstants();
            System.out.println(" length =====  " + obj.length);

            Method getValue = clazz.getMethod("getValue");
            Method getDescription = clazz.getMethod("getDescription");

            for (Object o : obj) {
                System.out.println("value = " + getValue.invoke(o) + ", des = " + getDescription.invoke(o));
            }


        }catch (Exception e){
            System.out.println(e);

        }
    }

//    public void test(Map<String, Object> titleMap, Class clazz, MultipartFile file, ProjectEnums.Gclx projectType, String projectId) throws Exception {
//        //定义sheet的map集合
//        Map<String, Map> sheetMap = new LinkedHashMap<>();
//
//        Map<String, Object> dataAttr = new LinkedHashMap<>();
//        dataAttr.put("title", titleMap);
//        dataAttr.put("class", clazz.getName()); // "com.piesat.jsslt.hhzy_service.model.aqjc.AqjcSpwygccgb"
//        sheetMap.put("sheet1", dataAttr);
//
////        clazz.newInstance()
//        Method setReadOnly = clazz.getMethod("setSlgcdwId", String.class);
//        String s ="test2";
//        setReadOnly.invoke(t,s);
//
//        // 获取文件信息
//        byte[] byteArr = file.getBytes();
//        InputStream inputStream = new ByteArrayInputStream(byteArr);
//
//        Map<String, List> listMap = ExcelExportAndImportUtil.excelImport(sheetMap, inputStream);
//        if(listMap!=null){
//            List<GeModel> list = listMap.get("sheet1");
//            if (list != null && list.size() > 0) {
//                for (GeModel info : list) {
//                    SysUser sysUser = (SysUser) tokenManager.getShiroUser().getObj();
//                    if (!sysUser.getType().equals(UserEnums.Client.SG)) {
//                        throw new ServiceException(ExceptionStatusCode.NO_PERMISSION_TO_SERVICE);
//                    }
//                    if (StringUtil.isNullValue(projectId) || projectType == null) {
//                        throw new ServiceException(ExceptionStatusCode.IMPORT_ERROR);
//                    }
//                    Project project = projectService.findInfoByGclx(projectId, projectType);
//                    if (project.getProject() == null) {
//                        throw new ServiceException(ExceptionStatusCode.IMPORT_ERROR);
//                    }
//                    info.setSlgcdwId(sysUser.getSsdwId());
//                    // 查询所属行政单位ID
//                    Engineering engineering = engineeringService.findByID(sysUser.getSsdwId());
//                    info.setSlxzdwId(engineering.getSlxzdwId());
//                    info.setProjectId(projectId);
//                    info.setProjectType(projectType);
//                    super.insert(info);
//                }
//            }
//        }
//    }
}
