package Entites;

public class ClientEntity {

	private String host;
	private int port;

	public void setHost(String host) {
		this.host = new String(host);
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getHost() {
		return host;
	}

	public int getPort() {
		return port;
	}
}