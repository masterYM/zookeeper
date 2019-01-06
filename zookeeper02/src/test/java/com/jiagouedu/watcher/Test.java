package com.jiagouedu.watcher;


import com.jiagouedu.zkclient.watcher.ZkClientWatcher;

public class Test {

   public static void main(String[] args) throws InterruptedException {
      ZkClientWatcher zkClientWatcher=new ZkClientWatcher();
      String path="/wukong";
      zkClientWatcher.deleteRecursive(path);
      zkClientWatcher.lister(path);
      zkClientWatcher.createPersistent(path,"123");
      Thread.sleep(2000);
      zkClientWatcher.writeData(path,"abc");
      Thread.sleep(Integer.MAX_VALUE);
   }
}
