package com.meoos.rpc.scanner;

import java.io.File;
import java.io.FileFilter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Meoos
 * @Version 1.0.0
 * @description 类扫描器
 */
public class ClassScanner {

    /**
     * 文件
     */
    private static final String PROTOCOL_FILE = "file";

    /**
     * jar包
     */
    private static final String PROTOCOL_JAR = "jar";

    /**
     * class文件的后缀
     */
    private static final String CLASS_FILE_SUFFIX = ".class";

    public static List<String> getClassNameList(String packageName){
        //第一个class类的集合
        List<String> classNameList = new ArrayList<String>();



        return classNameList;
    }

    private static String findAndAddClassesInPackageByJar(String packageName, List<String> classNameList, boolean recursive, String packageDirName, URL url){


        return packageName;
    }

    /**
     * 扫描当前工程中指定包下的所有类信息
     * @param packageName 扫描的包名
     * @param packagePath 包在磁盘上的完整路径
     * @param recursive 是否递归调用
     * @param classNameList 类名称的集合
     */
    private static void findAndAddClassesInPackageByFile(String packageName, String packagePath, final boolean recursive, List<String> classNameList){
        //获取此包的目录 建立一个File
        File dir = new File(packagePath);
        //如果不存在或者也不是目录就直接返回
        if (!dir.exists()||!dir.isDirectory()){
            return;
        }
        //如果存在，就获取包下的所有文件，包括目录
        File[] dirFiles = dir.listFiles(new FileFilter() {
            //自定义过滤规则 如果可以循环(包含子目录) 或则是以.class结尾的文件(编译好的java类文件)
            public boolean accept(File file) {
                return (recursive && file.isDirectory()) || (file.getName().endsWith(".class"));
            }
        });
        //循环所有文件
        for (File file : dirFiles){
            //如果是目录，继续扫描
            if (file.isDirectory()){
                findAndAddClassesInPackageByFile(packageName+"."+file.getName(),file.getAbsolutePath(),recursive,classNameList);
            }else {
                //如果是java类文件 去掉后面的.class 只留下类名
                String className = file.getName().substring(0,file.getName().length()-6);
                //添加到集合
                classNameList.add(packageName+"."+className);
            }
        }
    }

}
