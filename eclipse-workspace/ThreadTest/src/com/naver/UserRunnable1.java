package com.naver;

// runnable 인터페이스를 구현하여 run() 메소드 내부에 실행할 코드 작성
public class UserRunnable1 implements Runnable {

   // my를 선언해도 null일 뿐
   private Thread my;

   public UserRunnable1() {
      // TODO Auto-generated constructor stub
   }

   // 파라미터로 받은 my를 사용한다.
   public UserRunnable1(Thread my) {
      super();
      this.my = my;
   }

   @Override
   public void run() {

      // my 스레드가 끝날 때까지 아래 코드가 실행되지 않는다.
      try {
         my.join();
      } catch (InterruptedException e1) {
         // TODO Auto-generated catch block
         e1.printStackTrace();
      }

      for (int i = 0; i < 10; i++) {
         char c = (char) (65 + i);
         System.out.println(c);
         try {
            Thread.sleep(500);
         } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }

      }
   }
}