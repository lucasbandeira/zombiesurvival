package com.zombiesurvival.rest;

import java.util.Collection;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.zombiesurvival.business.ZombieSurvivalBusiness;
import com.zombiesurvival.dao.SurvivorDao;
import com.zombiesurvival.model.Inventory;
import com.zombiesurvival.model.Survivor;

@Path("/rest")
public class ZombieSurvivalREST {
	private SurvivorDao survivorDao = new SurvivorDao();
	private ZombieSurvivalBusiness zombieSurvivalBusiness = new ZombieSurvivalBusiness();
	
	/**
	 * @api {get} /rest/survivors Request Survivors information
	 * @apiName GetSurvivors
	 * @apiGroup Survivor
	 * 
	 * @apiSuccess {String}		[id]		id of the Survivor.
	 * @apiSuccess {String}		[name]		name of the Survivor.
	 * @apiSuccess {Integer} 	[age] 		age of the Survivor.
	 * @apiSuccess {String} 	[gender] 	gender of the Survivor.
	 * @apiSuccess {String} 	[latitude] 	latitude of the Survivor.
	 * @apiSuccess {String} 	[longitude]	longitude of the Survivor.
	 * @apiSuccess {Integer} 	[delation] 	delation count how many delation.
	 * @apiSuccess {Boolean} 	[infected]	infected if is infected.
	 *
	 * @apiSuccessExample Success-Response:
	 *   HTTP/1.1 200 OK
	 *   [
	 *	  {
	 *	    "id": 2,
	 *	    "name": "Maria",
	 *	    "age": 30,
	 *	    "gender": "FEMALE",
	 *	    "latitude": "-123696",
	 *	    "longitude": "123686",
	 *	    "delation": 0,
	 *	    "infected": false
	 *	  },
	 *	  {
	 *	    "id": 3,
	 *	    "name": "Mariana",
	 *	    "age": 20,
	 *	    "gender": "FEMALE",
	 *	    "latitude": "-123696",
	 *	    "longitude": "123686",
	 *	    "delation": 0,
	 *	    "infected": false
	 *	  },
	 *	  {
	 *	    "id": 1,
	 *	    "name": "Lucas",
	 *	    "age": 25,
	 *	    "gender": "MALE",
	 *	    "latitude": "-123696",
	 *	    "longitude": "125686",
	 *	    "delation": 0,
	 *	    "infected": false
	 *	  }
	 *	]
	 */
	@Path("/survivors")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Survivor> getSurvivors() {
		return survivorDao.getSurvivors();
	}
	
	/**
	 * @api {get} /survivors/:name Request Survivors information
	 * @apiName GetSurvivorsByName
	 * @apiGroup Survivor
	 *
	 * @apiParam {name} name of the Survivor.
	 *
	 * @apiSuccess {String}		[id]		id of the Survivor.
	 * @apiSuccess {String}		[name]		name of the Survivor.
	 * @apiSuccess {Integer} 	[age] 		age of the Survivor.
	 * @apiSuccess {String} 	[gender] 	gender of the Survivor.
	 * @apiSuccess {String} 	[latitude] 	latitude of the Survivor.
	 * @apiSuccess {String} 	[longitude]	longitude of the Survivor.
	 * @apiSuccess {Integer} 	[delation] 	delation count how many delation.
	 * @apiSuccess {Boolean} 	[infected]	infected if is infected.
	 *
	 *
	 * @apiSuccessExample Success-Response:
	 *     HTTP/1.1 200 OK
	 *		[
	 *		  {
	 *		    "id": 2,
	 *		    "name": "Maria",
	 *		    "age": 30,
	 *		    "gender": "FEMALE",
	 *		    "latitude": "-123696",
	 *		    "longitude": "123686",
	 *		    "delation": 0,
	 *		    "infected": false
	 *		  },
	 *		  {
	 *		    "id": 3,
	 *		    "name": "Mariana",
	 *		    "age": 20,
	 *		    "gender": "FEMALE",
	 *		    "latitude": "-123696",
	 *		    "longitude": "123686",
	 *		    "delation": 0,
	 *		    "infected": false
	 *		  }
	 *		]
	 */
	@Path("/survivors/{name}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Survivor> getSurvivors(@PathParam("name") String name) {
		return survivorDao.getSurvivorsByName(name);
	}
	
	/**
	 * @api {post} /survivor Create Survivor
	 * @apiName CreateSurvivor
	 * @apiGroup Survivor
	 *
	 * @apiParamExample {json} Request-Example:
	 *     {
	 *       "name": "Maria",
	 *       "age": 30,
	 *       "gender": 0 , //0 female and 1 male
	 *       "latitude": "-123696",
	 *       "longitude": "123686"
	 *     }
	 *     
	 * @apiSuccessExample Success-Response:
	 *     HTTP/1.1 201 OK
	 *     	Survivor added
	 */	
	@Path("/survivor")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addSurvivor(Survivor survivor){
		if(zombieSurvivalBusiness.survivorValidator(survivor))
			return Response.status(201).entity("Survivor added").build();
		
		return Response.status(400).entity("Item is not valid").build();
	}
	
	/**
	 * @api {post} /survivor/:survivorId/inventory Create a list of Inventories
	 * @apiName CreateInventories
	 * @apiGroup Inventory
	 *
	 * @apiParamExample {json} Request-Example:
	 * 	[
	 *     {
	 *       "amount": 1,
	 *       "item": : {
	 *       	"id": "WATER"
	 *       },
	 *     },
	 *     {
	 *       "amount": 1,
	 *       "item": : {
	 *       	"id": "AMMUNITION"
	 *       },
	 *     },
	 *     {
	 *       "amount": 2,
	 *       "item": : {
	 *       	"id": "MEDICATION"
	 *       },
	 *     },
	 *     {
	 *       "amount": 0,
	 *       "item": : {
	 *       	"id": "FOOD"
	 *       },
	 *     }
	 *  ]
	 *     
	 * @apiSuccessExample Success-Response:
	 *     HTTP/1.1 201 OK
	 *     	Created a list of Inventories
	 */	
	@Path("/survivor/{survivorId}/inventory")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addSurvivorInventory(@PathParam("survivorId") int survivorId, List<Inventory> inventories){
			if(zombieSurvivalBusiness.inventoryValidator(inventories, survivorId))
				return Response.status(201).entity("Created a list of Inventories").build();
			
			return Response.status(400).entity("Item is not valid").build();
	}
	
	/**
	 * @api {put} /survivor/:survivorId Update a Survivor.
	 * @apiName UpdateSurvivor
	 * @apiGroup Survivor
	 *
	 * @apiParamExample {json} Request-Example:
	 *     {
	 *       "latitude": "14235325",
	 *       "longitude": "4354543"
	 *     }
	 *     
	 *     or
	 *     
	 *     {
	 *       "infected": true
	 *     }
	 *     
	 * @apiSuccessExample Success-Response:
	 *     HTTP/1.1 200 OK
	 *     	Survivor updated
	 */	
	@Path("/survivor/{survivorId}")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateSurvivor(Survivor survivor, @PathParam("survivorId") int survivorId){
		if(zombieSurvivalBusiness.survivorUpdateValidator(survivor, survivorId))
			return Response.status(200).entity("Survivor updated").build();
		
		return Response.status(400).entity("Item is not valid").build();
	}
	
	//Ainda não implementado 
//	@Path("/survivor/trade")
//	@POST
//	@Consumes(MediaType.APPLICATION_JSON)
//	public Response trade(List<Inventory> inventories){
//		if(zombieSurvivalBusiness.tradeValidator(inventories))
//			return Response.status(200).entity("Survivor updated").build();
//		
//		return Response.status(400).entity("Item is not valid").build();
//	}
	
	/**
	 * @api {get} /report-percent/:category Show report
	 * @apiName Report
	 * @apiGroup Survivor
	 *
	 * @apiParam {category} category of the Report. 0 - Percent Infected or 1 - Percent of not infected
	 *     
	 * @apiSuccessExample Success-Response:
	 *     HTTP/1.1 200 OK
	 *     	Percentage of infected is :value
	 *      or
	 *      Percentage of not infected is :value
	 */	
	@Path("/report-percent/{category}")
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getReportPercentage(@PathParam("category") int category){
		return Response.status(200).entity(zombieSurvivalBusiness.getReportPercentage(category)).build();
	}
}
