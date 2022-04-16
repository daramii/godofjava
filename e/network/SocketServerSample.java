package e.network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerSample {

    public static void main(String[] args) {
        SocketServerSample sample = new SocketServerSample();
        //sample.startServer();
        sample.startReplyServer();
    }

    public void startServer() {

        ServerSocket server = null;
        Socket client = null;
        try{
            server = new ServerSocket(9999); //9999라는 포트번호를 이용하여 ServerSocket 객체를 생성. = 다른 프로그램에서 이 프로그램에서 띄운 서버로 접근하려면 9999 포트를 사용하면 된다.
            while(true) {
                System.out.println("Server:Waiting for request.");
                client = server.accept(); //ServerSocket의 accept 메소드를 호출하면, 다른 원격 호출을 "대기"하는 상태가 된다. 연결이 완료 되면, Socket 객체인 client라는 변수에 할당된다.
                System.out.println("Server:Accepted.");
                InputStream stream = client.getInputStream(); //"데이터를 받기 위해서" Socket 클래스에 선언된 getInputStream() 메소드를 호출해서 InputStream 객체를 받는다.
                BufferedReader in = new BufferedReader( new InputStreamReader(stream));
                String data = null;
                StringBuilder receivedData = new StringBuilder();
                while((data=in.readLine())!=null) {
                    receivedData.append(data);
                }
                System.out.println("Received data:" + receivedData);
                in.close();
                stream.close();
                client.close();
                if(receivedData != null && "EXIT".equals(receivedData.toString())) {
                    System.out.println("Stop SocketServer");
                    break;
                }
                System.out.println("----------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(server != null) {
                try{
                    server.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public void startReplyServer() {
        ServerSocket server = null;
        Socket client = null;
        try{
            server=new ServerSocket(9999);
            while(true) {
                System.out.println("Server:Waiting for request.");
                client=server.accept();
                System.out.println("Server:Accepted.");
                OutputStream stream=client.getOutputStream();
                BufferedOutputStream out=new BufferedOutputStream(stream);
                out.write("OK".getBytes());
                out.close();
                stream.close();
                client.close();
                System.out.println("----------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(server != null) {
                try{
                    server.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
