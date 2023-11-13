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

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Command command, ByteBuf byteBuf) throws Exception {
        try {
            Header header = command.header();
            Payload payload = command.payload();
            byte[] hEncoder = header.encoder();
            if (hEncoder != null) {
                byteBuf.writeBytes(hEncoder);
            }
            byte[] encoder = payload.encoder();
            if (encoder != null) {
                byteBuf.writeBytes(encoder);
            }
        } catch (Exception e) {
            // TODO close channel
        }
    }
    private void encode(Header header, ByteBuf byteBuf) {

    }
}
