package br.com.frimesa.ws.otm.resource;

import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.frimesa.ws.domain.TransmissionAck;

import br.com.frimesa.ws.otm.service.OTMService;
import br.com.frimesa.ws.util.Util;

@Path("/otm/invoice")
public class OTMResource {
	
	OTMService service = new OTMService();
	
	@PostConstruct
	private void init() {
		Util.LOG = true;
	}
	
	
	@POST
	@Path("/pagamento")
	@Consumes(MediaType.TEXT_XML)
	@Produces("application/xml")
    public Response inserirIntegrationOTM(String xml)  {
		System.out.println("teste 3");
		return Response.status(Status.OK)				
				.entity(service.inserir(xml))
				.type(MediaType.APPLICATION_XML)
				.build();
    }

}
