package com.jiagouedu.zookeeper.znode;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

public class ZookeeperCrud {
   private String connectString="192.168.137.60:2180,192.168.137.62:2180,192.168.137.61:2180";

   private ZooKeeper zookeeper;

   public ZookeeperCrud() {
      try {
         zookeeper=new ZooKeeper(connectString,5000,null);
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public String createPersistent(String path,String data){
      try {
         return  zookeeper.create(path, data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
      } catch (KeeperException e) {
         e.printStackTrace();
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      return  null;
   }


   public String createEphemeral(String path,String data){
      try {
         return  zookeeper.create(path, data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
      } catch (KeeperException e) {
         e.printStackTrace();
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      return  null;
   }



   /***
    * 更新信息
    * @param path
    * @return
    * @throws KeeperException
    * @throws InterruptedException
    */
   public String getData(String path) throws KeeperException, InterruptedException {
      byte data[] = zookeeper.getData(path,false,null);
      data = (data == null)? "null".getBytes() : data;
      return new String(data);
   }


   /***
    * 更新信息
    * @param path
    * @param data
    * @return
    * @throws KeeperException
    * @throws InterruptedException
    */
   public Stat setData(String path, String data) throws KeeperException, InterruptedException {
      return zookeeper.setData(path, data.getBytes(), -1);
   }

   /***
    * 是否存在
    * @param path
    * @return
    * @throws KeeperException
    * @throws InterruptedException
    */
   public Stat exists(String path) throws KeeperException, InterruptedException {
      return zookeeper.exists(path,false);

   }


   /***
    * 删除
    * @param path
    * @return
    * @throws KeeperException
    * @throws InterruptedException
    */
   public void delete(String path) throws KeeperException, InterruptedException {
      zookeeper.delete(path,-1);
   }
   /***
    * 删除 递归
    * @param path
    * @return
    * @throws KeeperException
    * @throws InterruptedException
    */
   public void deleteRecursive(String path) throws KeeperException, InterruptedException {
      ZKUtil.deleteRecursive(zookeeper, path);
   }

   public void close() throws InterruptedException {
      zookeeper.close();
   }
}
