package business.contact_us;

import org.apache.poi.ss.usermodel.Row;

import test.context.TestContext;

public class ContactUsModel {

	private String contactName;
	private String contactEmail;
	private String message;

	protected String getContactUsername() {
		return this.contactName;
	}

	protected String getContactEmail() {
		return this.contactEmail;
	}

	protected String getMessage() {
		return this.message;
	}

	enum ContactFormAttributes {
		CONTACT_NAME(0), CONTACT_EMAIL(1), CONTACT_MESSAGE(2);

		private int index;

		private ContactFormAttributes(int index) {
			this.index = index;
		}

		public int getIndex() {
			return this.index;
		}

	}

	public void setupModel(String contactUsername, String contactEmail, String message) {
		setContactName(contactUsername);
		setContactEmail(contactEmail);
		setContactMessage(message);
	}

	private void setContactMessage(String message) {

		this.message = message;

	}

	private void setContactEmail(String contactEmail) {

		this.contactEmail = contactEmail;
	}

	private void setContactName(String contactName) {

		this.contactName = contactName;
	}

	public ContactUsModel() {
		this(TestContext.getRowByTaggedIdSheet());
	}

	public ContactUsModel(Row row) {
		setContactName(row.getCell(ContactFormAttributes.CONTACT_NAME.getIndex()).getStringCellValue());
		setContactEmail(row.getCell(ContactFormAttributes.CONTACT_EMAIL.getIndex()).getStringCellValue());
		setContactMessage(row.getCell(ContactFormAttributes.CONTACT_MESSAGE.getIndex()).getStringCellValue());

	}

}
