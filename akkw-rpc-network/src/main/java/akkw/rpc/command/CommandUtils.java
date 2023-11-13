package akkw.rpc.command;

import akkw.rpc.netty.command.Header;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

public class CommandUtils {
    public static Object decoder(ByteBufAllocator allocator, ByteBuf frame) {
        ByteBuf headerByteBuf = null;
        try {
            int headerLength = frame.readInt();
            if (headerLength <= 0) {
                return null;
            }
            headerByteBuf = allocator.directBuffer(headerLength);
            if (headerByteBuf.writableBytes() >= headerLength) {

                Header header = new Header();
                header.decoder(headerByteBuf.array());
            }
        } catch (Exception e) {

        } finally {
            assert headerByteBuf != null;
            headerByteBuf.release();
        }
        return null;
    }
}
