/**
 * All rights Reserved, Designed By Suixingpay.
 *
 * @author: li_yang@suixingpay.com
 * @date: 2017/3/20 下午8:39
 * @Copyright: ©2017 Suixingpay. All rights reserved.
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用�?��??
 */
package com.suixingpay.mybatis.service;

import java.util.concurrent.LinkedBlockingDeque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @Description: 启动
 * @author: li_yang@suixingpay.com
 * @date: 2017/3/20 下午8:39
 * @version: V1.0
 */
@SpringBootApplication
@ImportResource(value = {"classpath:spring-context.xml"})
public class ServiceApplication {

    private static LinkedBlockingDeque<Boolean> RUN = new LinkedBlockingDeque<Boolean>();

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws Exception the exception
     */
    public static void main(String[] args) throws Exception {

        SpringApplication springApplication = new SpringApplication(ServiceApplication.class);

        springApplication.run(args);
        //logger.info(print());
        System.out.println(print());

        while (RUN.take()) {
        }
    }

    /**
     * Stop.
     */
    static void stop() {
        RUN.add(false);
    }

    private static String print(){
        StringBuffer sb = new StringBuffer();
        sb.append("                   _ooOoo_\n");
        sb.append("                  o8888888o\n");
        sb.append("                  88\" . \"88\n");
        sb.append("                  (| ^_^ |)\n");
        sb.append("                  O\\  =  /O\n");
        sb.append("               ____/`---'\\____\n");
        sb.append("             .'  \\\\|     |//  `.\n");
        sb.append("            /  \\\\|||  :  |||//  \\ \n");
        sb.append("           /  _||||| -:- |||||-  \\ \n");
        sb.append("           |   | \\\\\\  -  /// |   |\n");
        sb.append("           | \\_|  ''\\---/''  |   |\n");
        sb.append("           \\  .-\\__  `-`  ___/-. /\n");
        sb.append("         ___`. .'  /--.--\\  `. . __\n");
        sb.append("      .\"\" '<  `.___\\_<|>_/___.'  >'\"\".\n");
        sb.append("     | | :  `- \\`.;`\\ _ /`;.`/ - ` : | |\n");
        sb.append("     \\  \\ `-.   \\_ __\\ /__ _/   .-` /  /\n");
        sb.append("======`-.____`-.___\\_____/___.-`____.-'======\n");
        sb.append("                   `=---='\n");
        sb.append("...................................................\n");
        return sb.toString();
    }


}
