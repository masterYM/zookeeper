package com.jiagouedu.znode;
import com.jiagouedu.zkclient.znode.ZkClientCrud;

public class ZkclientTest {
   public static void main(String[] args) {
      ZkClientCrud zkClientCrud=new ZkClientCrud();
      User user=new User();
      user.setAge(18);
      user.setName("wukong");
      zkClientCrud.createPersistent("/abc",user);
      System.out.println(zkClientCrud.readData("/abc"));;



   }
}
