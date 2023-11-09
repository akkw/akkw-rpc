package akkw.rpc.coder;

import akkw.rpc.netty.command.Command;
import akkw.rpc.netty.command.CommandEnum;
import akkw.rpc.netty.command.Header;
import akkw.rpc.netty.command.Payload;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.util.Map;

public abstract class AbstractEncoderCoder extends MessageToByteEncoder<Command> {

    private final Map<CommandEnum, AbstractEncoderCoder> coderMap;

    public AbstractEncoderCoder(Map<CommandEnum, AbstractEncoderCoder> coderMap) {
        this.coderMap = coderMap;
    }

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Command command, ByteBuf byteBuf) throws Exception {
        Header header = command.header();
        AbstractEncoderCoder abstractEncoderCoder = coderMap.get(header.getCommand());
        encode(header, byteBuf);
        abstractEncoderCoder.encode(command.payload(), byteBuf);
    }
    private void encode(Header header, ByteBuf byteBuf) {

    }
    protected abstract void encode(Payload payload, ByteBuf byteBuf);
}
