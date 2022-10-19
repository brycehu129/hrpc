package com.meoos.rpc.test.scanner;

import com.meoos.rpc.scanner.ClassScanner;
import com.meoos.rpc.scanner.reference.RpcReferenceScanner;
import com.meoos.rpc.scanner.server.RpcServiceScanner;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * @Author Meoos
 * @Version 1.0.0
 * @description 扫描测试
 */
public class ScannerTest {

    /**
     * 扫描com.meoos.rpc.test.scanner包下所有的类
     * @throws IOException
     */
    @Test
    public void testScannerClassNameList() throws IOException {
        List<String> classNameList = ClassScanner.getClassNameList("com.meoos.rpc.test.scanner");
        classNameList.forEach(System.out::println);
    }

    /**
     * 扫描com.meoos.rpc.test.scanner包下所有标注了@RpcService注解的类
     * @throws IOException
     */
    @Test
    public void testScannerClassNameListByRpcService() throws IOException {
        RpcServiceScanner.doScannerWithRpcServiceAnnotationFilterAndRegistryService("com.meoos.rpc.test.scanner");
    }

    /**
     * 扫描com.meoos.rpc.test.scanner包下所有标注了@RpcReference注解的类
     * @throws IOException
     */
    @Test
    public void testScannerClassNameListByRpcReference() throws IOException {
        RpcReferenceScanner.doScannerWithRpcReferenceAnnotationFilter("com.meoos.rpc.test.scanner");
    }


}
