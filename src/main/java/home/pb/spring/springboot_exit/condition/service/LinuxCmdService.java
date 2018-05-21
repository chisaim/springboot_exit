package home.pb.spring.springboot_exit.condition.service;

public class LinuxCmdService implements CmdService {
    @Override
    public void print() {
        System.out.println("This is LinuxCmdService.print()...");
    }
}
