package akkw.rpc.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class NettyServer {

    private final NettyServerConfig nettyServerConfig;

    private final ServerBootstrap serverBootstrap;


    public NettyServer(NettyServerConfig nettyServerConfig) {
        this.serverBootstrap = new ServerBootstrap();
        this.nettyServerConfig = nettyServerConfig == null ? new NettyServerConfig() : nettyServerConfig;
    }

    public void start() {
        serverBootstrap
                .channel(NioServerSocketChannel.class)
                .handler(new ServerSocketHandler())
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast();
                    }
                });
    }
}
