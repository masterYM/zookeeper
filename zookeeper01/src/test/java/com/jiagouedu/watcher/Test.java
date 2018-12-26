package com.jiagouedu.watcher;

import com.jiagouedu.zookeeper.watcher.ZookeeperWatcher2;
import com.jiagouedu.zookeeper.znode.ZookeeperCrud;
import org.apache.zookeeper.KeeperException;

public class Test {
   public static void main(String[] args) throws KeeperException, InterruptedException {
      ZookeeperWatcher2 zookeeperCrud=new ZookeeperWatcher2();
      //ZookeeperWatcher2 zookeeperCrud2=new ZookeeperWatcher2();
//      zookeeperCrud.getData("/wukong",true);
//      zookeeperCrud.getData("/wukong",false);
//      Thread.sleep(1000);
//        zookeeperCrud.delete("/wukong");
       // Thread.sleep(2000);
      zookeeperCrud.createEphemeral("/wukong","abc");

   //   System.out.println(zookeeperCrud.getData("/wukong",true));;
      Thread.sleep(Long.MAX_VALUE);
   }
}
