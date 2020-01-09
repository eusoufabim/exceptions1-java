package model.entities;

//import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
	private Integer  numQuarto;
	private Date checkin;
	private Date checkout;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Integer getNumQuarto() {
		return numQuarto;
	}
	public void setNumQuarto(Integer numQuarto) {
		this.numQuarto = numQuarto;
	}
	public Date getCheckin() {
		return checkin;
	}
	public Date getCheckout() {
		return checkout;
	}
	public Reserva(Integer numQuarto, Date checkin, Date checkout) {
		this.numQuarto = numQuarto;
		this.checkin = checkin;
		this.checkout = checkout;
	}
	
	public Reserva() {
	
	}
	
	public long duracao() {
		long diff = checkout.getTime() - checkin.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public String atualizarDatas(Date checkin, Date checkout) {
		Date now = new Date();
		
		if (checkin.before(now) || checkout.before(now)) {
			return "As datas devem ser futuras.";
		} 

		if (!checkout.after(checkin)) {
			return "Data de CheckOut deve ser maior que a data de CheckIn.";
		}
		
		this.checkin = checkin;
		this.checkout = checkout;
		
		return null;
	}
		
	@Override
	public String toString() {
		return "Reserva: Quarto " + this.getNumQuarto() + ", check-in: " + sdf.format(this.getCheckin()) + ", check-out: " + sdf.format(this.getCheckout()) + ", dura��o: "+ this.duracao() +" noites.";		
	}
		
}
