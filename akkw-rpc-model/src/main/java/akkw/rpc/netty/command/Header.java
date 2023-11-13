package akkw.rpc.netty.command;

public class Header {
    private CommandEnum command;

    private Payload payload;
    public CommandEnum getCommand() {
        return command;
    }


    public byte[] encoder() {
        return null;
    }


    public void decoder(byte[] in) {

    }
}
