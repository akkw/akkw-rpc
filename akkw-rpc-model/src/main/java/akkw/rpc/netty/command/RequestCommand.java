package akkw.rpc.netty.command;

public class RequestCommand implements Command {

    private Header header;

    private Payload payload;

    @Override
    public Header header() {
        return null;
    }

    @Override
    public Payload payload() {
        return null;
    }

    public static class RequestCommandPayload implements Payload {

    }
}
