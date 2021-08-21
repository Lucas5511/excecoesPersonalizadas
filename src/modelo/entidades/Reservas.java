package modelo.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import modelo.excecoes.ExcecoesDeDominio;

public class Reservas {

	private Integer numeroDoQuarto;
	private Date checkIn;
	private Date checkOut;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservas(Integer numeroDoQuarto, Date checkIn, Date checkOut) {
		if (!checkOut.after(checkIn)) {
			throw new ExcecoesDeDominio ("A data do Check-out precisa ser colocada depois da data de Check-in ");
		} 
		this.numeroDoQuarto = numeroDoQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getNumeroDoQuarto() {
		return numeroDoQuarto;
	}

	public void setNumeroDoQuarto(Integer numeroDoQuarto) {
		this.numeroDoQuarto = numeroDoQuarto;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duracao() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public void datasAtualizadas(Date checkIn, Date checkOut) {
		Date agora = new Date();
		if (checkIn.before(agora) || checkOut.before(agora)) {
			throw new ExcecoesDeDominio("As datas de reserva precisam ser futuras");
		} 
		if (!checkOut.after(checkIn)) {
			throw new ExcecoesDeDominio ("A data do Check-out precisa ser colocada depois da data de Check-in ");
		} 
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
	}
	
	@Override
	public String toString() {
		return "Quarto "
				+numeroDoQuarto
				+", Check-in: "
				+ sdf.format(checkIn)
				+", Check-out: "
				+ sdf.format(checkOut)
				+", "
				+duracao()
				+" noites. ";
				
	}
	
}
