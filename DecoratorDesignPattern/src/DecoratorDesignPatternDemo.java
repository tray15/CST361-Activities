
public class DecoratorDesignPatternDemo {

	public static void main(String[] args) {
		NotificationFactory factory = new NotificationFactory();
		Notification notification = factory.notify("text");
		notification.sendNotification();
		notification = factory.notify("email");
		notification.sendNotification();
		
		Notification dNotification = new SecondaryMessageNotificationDecorator(notification);
		dNotification.sendNotification();
	}

}
