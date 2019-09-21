package com.java.mapper;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import java.util.Iterator;

public class ConnectionMapper  implements ExceptionMapper<ConstraintViolationException> {

  @Override
  public Response toResponse(ConstraintViolationException e) {
    assert e != null;


    StringBuilder fields = new StringBuilder();
    StringBuilder messages = new StringBuilder();
    Object[] items = e.getConstraintViolations().toArray();
    for (int i = 0; i < e.getConstraintViolations().size(); i++) {
      ConstraintViolation v = (ConstraintViolation) items[i];

      String msg = v.getMessage();
      Path path = v.getPropertyPath();
      String lastNode = "";
      Iterator<Path.Node> nodes = path.iterator();
      while (nodes.hasNext()) {
        Path.Node node = nodes.next();
        lastNode = node.getName();
      }
      System.out.println(msg);
      fields.append(lastNode);
      messages.append(lastNode + " " + msg);
      if (i < e.getConstraintViolations().size() - 1) {
        fields.append(",");
        messages.append(",\n");
      }
    }
    return Response.status(Response.Status.BAD_REQUEST).build();
  }
}
