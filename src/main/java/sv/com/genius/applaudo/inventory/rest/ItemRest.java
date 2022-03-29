package sv.com.genius.applaudo.inventory.rest;

import sv.com.genius.applaudo.inventory.controller.Item;
import sv.com.genius.applaudo.inventory.entities.ItemEntity;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/app")
public class ItemRest {

    @EJB
    private Item itemController;

    /**
     * {@code GET  /items} : get all the items.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of items in body.
     */
    @GET
    @Path("/items")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<ItemEntity> items = itemController.findAll();
        if(items == null) {
            Response.status(Response.Status.NOT_FOUND);
        }
        Map<String, Object> result = new HashMap<>();
        result.put("items", items);
        return Response.status(Response.Status.OK).entity(result).build();
    }

    /**
     * {@code GET  /items/:id} : get the "itemId" item.
     *
     * @param id the itemId of the item to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the item, or with status {@code 404 (Not Found)}.
     */
    @GET
    @Path("/items/{itemId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getItemId(Integer itemId) {
        List<ItemEntity> items = itemController.findByItemId(itemId);
        if(items == null) {
            Response.status(Response.Status.NOT_FOUND);
        }
        Map<String, Object> result = new HashMap<>();
        result.put("itemsId", items);
        return Response.status(Response.Status.OK).entity(result).build();
    }

    /**
     * {@code GET  /app/item?itemStatus={status}&itemName={name}}: get the "itemStatus" and "itemName" item.
     * @param status and name of the item to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the item, or with status {@code 404 (Not Found)}.
     */
    @GET
    @Path("/items/item")
    public Response getStatusAndName(
        @QueryParam("itemStatus") String itemStatus,
        @QueryParam("itemName") String itemName) {
        List<ItemEntity> items = itemController.findByItemStatusAndItemName(itemStatus, itemName);
        if(items == null) {
            Response.status(Response.Status.NOT_FOUND);
        }
        Map<String, Object> result = new HashMap<>();
        result.put("itemStatus", items);
        result.put("itemName", items);
        return Response.status(Response.Status.OK).entity(result).build();
    }

    /**
     * {@code POST  /items} : Create a new item.
     *
     * @param item the item to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new item, or with status {@code 400 (Bad Request)} if the item has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @POST
    @Path("/items")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(ItemEntity item){
        if(item.getId() != null) {
            Response.status(Response.Status.BAD_REQUEST);
        }
        itemController.insert(item);
        return Response.status(Response.Status.CREATED).build();
    }

}
