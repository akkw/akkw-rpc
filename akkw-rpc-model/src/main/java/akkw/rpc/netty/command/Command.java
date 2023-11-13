package akkw.rpc.netty.command;

public interface Command {

    Header header();

    Payload payload();



    default
}
