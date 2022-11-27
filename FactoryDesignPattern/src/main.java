
public class main {

	public static void main(String[] args) {
		NotificationFactory factory = new NotificationFactory();
		Notification notification = factory.notify("text");
		notification.sendNotification();
		notification = factory.notify("email");
		notification.sendNotification();
	}

}
