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

        @Override
        public byte[] encoder() {
            return new byte[0];
        }

        @Override
        public Payload decoder(byte[] in) {
            return null;
        }
    }
}
