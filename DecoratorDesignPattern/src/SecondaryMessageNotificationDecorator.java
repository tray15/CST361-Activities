
public class SecondaryMessageNotificationDecorator extends NotificationDecorator {

	public SecondaryMessageNotificationDecorator(Notification decoratedNotification) {
		super(decoratedNotification);
	}
	
	@Override
	public void sendNotification() {
		decoratedNotification.sendNotification();
		sendSecondNotification(decoratedNotification);
		
	}
	private void sendSecondNotification(Notification decoratedNotification) {
		System.out.println("This is a second notification from the notification decorator.");
	}
}
