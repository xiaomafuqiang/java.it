package main.file;

public class FileRuntimeInfo {

    public static void main(String[] args) {
        FileRuntimeInfo demo = new FileRuntimeInfo();
        demo.go();
    }

    private void go() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for(StackTraceElement s : stackTrace){
            System.out.println("类名：" + s.getClassName() + "  ,  java文件名：" + s.getFileName() + ",  当前方法名字：" + s.getMethodName() + ""
                    + " , 当前代码是第几行：" + s.getLineNumber() + ", " );
        }
    }

}
