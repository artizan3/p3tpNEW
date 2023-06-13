package persistencia;

import java.time.LocalDate;

import abonado.Abonado;
import empresa.Empresa;
import empresa.Tecnico;
import metodosdepago.FactoryPago;
/*
 * La clase UtiliPersistencia permite poder persistir y des-persistir el objeto empresa, funciona
 * como un DTO el cual comunica la persistencia con el software
 */
public class UtilPersistencia {
	/**
	 * Constructor de la clase <br>
	 * <br>
	 * <b>Pre</b>: Se espera que Empresa sea !=null<br>
	 * <b>Inv</b>: metodos Sets<br>
	 * <b>Post</b>: Se setean los valores de empresa para poder persistirla.<br>
	 * @param empresa para guardar la informacion y poder ser persistible
	 */
	public static EmpresaDTO empresaDTOFromEmpresa (Empresa empresa) {
		assert empresa != null : "La empresa no puede ser null";
		EmpresaDTO empresaDTO = new EmpresaDTO();
		empresaDTO.setListaAbonado(empresa.getListaAbonado());
		empresaDTO.setListaContrataciones(empresa.getListaContrataciones());
		empresaDTO.setListaTecnico(empresa.getListaTecnico());
		empresaDTO.setFechaAnio(empresa.getFecha().getYear());
		empresaDTO.setFechaMes(empresa.getFecha().getMonthValue());
		empresaDTO.setFechaDia(empresa.getFecha().getDayOfMonth());
		
		return empresaDTO;
		
	}
	/**
	 * Recibe un Objeto empresa en formato DTO <br>
	 * <br>
	 * <b>Pre</b>: Se espera que Empresa sea !=null.<br>
	 * <b>Inv</b>: <br>
	 * <b>Post</b>: Recontrsuye el objeto empresa a aprtir del DTO.<br>
	 * @param EmpresaDTO archivo para recopilar informacion y guardarla en empresa
	 */
	public static void empresaFromEmpresaDTO (EmpresaDTO empresaDTO) {

		Empresa.getInstance().setListaAbonado(empresaDTO.getListaAbonado());

		Empresa.getInstance().setListaContrataciones(empresaDTO.getListaContrataciones());
		Empresa.getInstance().setListaTecnico(empresaDTO.getListaTecnico());

		Empresa.getInstance().setCreacion(new FactoryPago());
		LocalDate fecha = LocalDate.of(empresaDTO.getFechaAnio(),empresaDTO.getFechaMes(),empresaDTO.getFechaDia());
		
		Empresa.getInstance().setFecha(fecha);
		
	}

	
	
}