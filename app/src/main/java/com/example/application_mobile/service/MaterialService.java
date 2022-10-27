package com.example.application_mobile.service;

public class MaterialService {
//    private List<Material> sendAndRequestResponse() {
//        //RequestQueue initialized
//        mRequestQueue = Volley.newRequestQueue(getContext());
//        List<Material>materialsList = new ArrayList<>();
//        jsonArrayRequest = new JsonArrayRequest(
//                Request.Method.GET,
//                url,
//                null,
//                new Response.Listener<JSONArray>() {
//                    @Override
//                    public void onResponse(JSONArray response) {
//                        Log.e("Response is", response.toString());
//
//                        for (int i = 0; i < response.length(); i++) {
//                            try {
//
//                                JSONObject obj = response.getJSONObject((i));
//                                Material material = new Material();
//                                material.setMaterialId(obj.getInt("materialId"));
//                                material.setName(obj.getString("name"));
//                                material.setQuantity(obj.getInt("quantity"));
//                                material.setQuantityType(obj.getString("quantityType"));
//                                material.setUnitCost(obj.getDouble("unitCost"));
//
//                                materialsList.add(material);
//
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                            }
//
//                        }
//
//                        System.out.println("===========================>"+materialsList);
//
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.e("Response", error.toString());
//            }
//        }
//
//        );
//        mRequestQueue.add(jsonArrayRequest);
//        return materialsList;
//    }
//
//private void fillMaterial() {
//    ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1);
//    adapter.add("Colombo");
//    adapter.add("Kandy");
//    adapter.add("Gampaha");
//    adapter.add("Galle");
//    adapter.add("Hatton");
//    adapter.add("Malabe");
//
//    //SET ADAPTER INSTANCE TO OUR SPINNER
//    material.setAdapter(adapter);
//
//}
}
