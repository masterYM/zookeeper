package com.jiagouedu.znode;/*
 * ━━━━━━如来保佑━━━━━━
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　┻　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━━━永无BUG━━━━━━
 * 图灵学院-悟空老师
 * www.jiagouedu.com
 * 悟空老师QQ：245553999
 */

import org.apache.jute.BinaryInputArchive;
import org.apache.zookeeper.server.ByteBufferInputStream;

import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;

public class SoecktLister {


    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(2181);
        Socket accept = serverSocket.accept();
        byte[] result = new byte[2048];
        accept.getInputStream().read(result);

        ByteBuffer bb = ByteBuffer.wrap(result);
        ByteBufferInputStream bbis = new ByteBufferInputStream(bb);
        BinaryInputArchive bia = BinaryInputArchive.getArchive(bbis);
        WkRequestHeader header2 = new WkRequestHeader();
        header2.deserialize(bia, "header");
        System.out.println(header2);
        bbis.close();

    }



}
