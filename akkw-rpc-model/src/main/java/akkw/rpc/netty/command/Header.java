package akkw.rpc.netty.command;

public class Header {
    private CommandEnum command;

    private Payload payload;
    public CommandEnum getCommand() {
        return command;
    }
}
