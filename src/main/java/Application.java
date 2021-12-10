import http.HttpServer;

/**
 * @description: TODO
 * @author: dongjunjie
 * @date: 2021/12/10 14:10
 */
public class Application {

    public static void main(String[] args) throws Exception{
        HttpServer server = new HttpServer(8081);// 8081为启动端口
        server.start();
    }
}

