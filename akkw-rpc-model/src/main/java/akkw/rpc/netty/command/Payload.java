package akkw.rpc.netty.command;

public interface Payload {

    byte[] encoder();

    Payload decoder(byte[] in);
}
