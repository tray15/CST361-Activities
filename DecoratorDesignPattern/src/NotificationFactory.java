
public class NotificationFactory {
	
	public Notification notify(String notification) {
		switch (notification) {
		case "text":
			return new SMSNotification();
		case "email":
			return new EmailNotification();
		}
		return null;
		
	}
}
