package home.pb.spring.springboot_exit.condition.service;

public class WindowsCmdService implements CmdService {
    @Override
    public void print() {
        System.out.println("This is WindowsCmdService.print()...");
    }
}
