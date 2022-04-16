package e.network;

import java.io.*;
import java.net.Socket;
import java.util.Date;

public class SocketClientSample {

    public static void main(String[] args) {
        SocketClientSample sample = new SocketClientSample();
        //sample.sendSocketSample();
        sample.sendAndReceiveSocketData();
    }

    public void sendSocketSample() {
        for(int i=0; i<3; i++) {
            sendSocketData("I liked java at " + new Date());
        }
        sendSocketData("EXIT");
    }

    public void sendSocketData(String data) {
        Socket socket = null;
        try{
            System.out.println("Client:Connecting");
            socket = new Socket("127.0.0.1", 9999); //127.0.0.1라는 IP는 같은 장비라는 것을 의미한다. 그리고 포트 번호는 서버쪽에 지정한 포트와 동일해야만 한다. 객체 생성 + 접속완료.
            System.out.println("Client: Connect status=" + socket.isConnected());
            Thread.sleep(1000);
            OutputStream stream = socket.getOutputStream();
            BufferedOutputStream out = new BufferedOutputStream(stream);
            byte[] bytes = data.getBytes();
            out.write(bytes);
            System.out.println("Client:Sent data=" + data);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(socket != null) {
                try{
                    socket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void sendAndReceiveSocketData() {
        Socket socket = null;
        try{
            System.out.println("Client:Connecting");
            socket=new Socket("127.0.0.1",9999); // 1)
            System.out.println("Client:Connect status="+socket.isConnected());
            Thread.sleep(1000);
            byte[] readByte=new byte[256];
            InputStream stream = socket.getInputStream();
            BufferedInputStream in = new BufferedInputStream(stream);
            in.read(readByte);
            System.out.println("Client:received data="+new String(readByte).trim());
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(socket != null) {
                try{
                    socket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
