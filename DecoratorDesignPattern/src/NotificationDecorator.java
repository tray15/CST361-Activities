
public abstract class NotificationDecorator implements Notification {
	protected Notification decoratedNotification;
	
	public NotificationDecorator(Notification decoratedNotification) {
		this.decoratedNotification = decoratedNotification;
	}
	
	@Override
	public void sendNotification() {
		decoratedNotification.sendNotification();
	}
}
