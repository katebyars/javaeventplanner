import java.util.HashMap;
import java.util.Map;
import models.eventPlanning;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import static spark.Spark.*;


public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        get("/form", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/eventPlanning", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();

            String beverage = request.queryParams("beverage");
            String food = request.queryParams("food");
            String entertainment = request.queryParams("entertainment");
            int guestCount = Integer.parseInt(request.queryParams("guestCount"));
            model.put("beverage", beverage);
            model.put("food", food);
            model.put("entertainment", entertainment);
            model.put("guestCount", guestCount);
            eventPlanning event = new eventPlanning(beverage, food, entertainment, guestCount);
            int totalPrice = event.priceCalculation(beverage, food, entertainment, guestCount);
            model.put("totalPrice", totalPrice);
            return new ModelAndView(model, "eventPlanning.hbs");
        }, new HandlebarsTemplateEngine());
    }
}

