package akkw.rpc.coder;

import akkw.rpc.command.CommandUtils;
import akkw.rpc.netty.NettyServerConfig;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

public abstract class AbstractDecoderCoder extends LengthFieldBasedFrameDecoder {
    public AbstractDecoderCoder() {
        super(NettyServerConfig.MAX_FRAME_LENGTH, 0, 4, 0, 4);
    }


    @Override
    protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
       try {
           ByteBuf frame = (ByteBuf) super.decode(ctx, in);
            assert frame != null;
           return CommandUtils.decoder(ctx.alloc(), frame);
       } catch (Exception e) {
           // TODO
       }
       return null;
    }
}
