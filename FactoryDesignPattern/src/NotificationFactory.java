
public class NotificationFactory {
	
	public Notification notify(String s) {
		switch (s) {
		case "text":
			return new SMSNotification();
		case "email":
			return new EmailNotification();
		}
		return null;
		
	}
}
