package com.jiagouedu.zookeeper04.controller;/* ━━━━━━如来保佑━━━━━━
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
 * 以往视频加小乔老师QQ：895900009
 * 悟空老师QQ：245553999
 */

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Map;

@Controller
public class MointorController {

   @Value("${mointor.zk1.host}")
   private String zk1;
   @Value("${mointor.zk2.host}")
   private String zk2;
   @Value("${mointor.zk.port}")
   private int port;


   @RequestMapping("/mointor/{command}")
   public String list(Map<String, Object> model, @PathVariable String command){
      try {
          String zk1=hander(command);
          model.put("zk1",zk1);
          model.put("zk2",zk1);
          model.put("zk3",zk1);
      } catch (IOException e) {
         e.printStackTrace();
      }
      return  "mointer";
   }

   public String hander(String command) throws IOException {
      Socket socket=new Socket(zk1,port);
      OutputStream outputStream=socket.getOutputStream();
      outputStream.write(command.getBytes());
      outputStream.flush();
      return IOUtils.toString(socket.getInputStream());


   }

}
