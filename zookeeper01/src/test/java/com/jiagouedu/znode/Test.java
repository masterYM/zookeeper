package com.jiagouedu.znode;

import com.jiagouedu.zookeeper.znode.ZookeeperCrud;
import org.apache.zookeeper.KeeperException;

public class Test {
   public static void main(String[] args) throws KeeperException, InterruptedException {
      ZookeeperCrud zookeeperCrud=new ZookeeperCrud();
      zookeeperCrud.createPersistent("/wukong","abc");
    if(null!=zookeeperCrud.exists("/wukong"))
      zookeeperCrud.delete("/wukong");
      zookeeperCrud.createEphemeral("/wukong","abc");
      System.out.println(zookeeperCrud.getData("/wukong"));

   }
}
