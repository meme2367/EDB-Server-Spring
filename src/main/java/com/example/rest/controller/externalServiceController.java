package com.example.rest.controller;

import com.example.rest.dto.simpleResponse;
import com.example.rest.model.externalService;
import com.example.rest.model.externalServiceDetail;
import com.example.rest.service.externalServiceService;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/external")
public class externalServiceController {

    @Autowired
    private final externalServiceService externalServiceService;
/*private :
/ final :
*/

    public externalServiceController(externalServiceService externalServiceService) {
        this.externalServiceService = externalServiceService;
    }

    @GetMapping("/available")
    public List<externalService> getAvailableExternalService() {
        return externalServiceService.getAvailableExternalService();
    }

    @PostMapping
    public simpleResponse insertExternalService(@RequestBody Map<String,Object> param) {
        String name = (String)param.get("name");
        String url = (String)param.get("url");
        String externalServiceDetailNames = (String) param.get("externalServiceDetailNames");

        externalServiceDetail externalServiceDetail = new externalServiceDetail(name,url,externalServiceDetailNames);

     return externalServiceService.insertExternalService(externalServiceDetail);
    }


    //getExternalServiceByNameAndExternalServiceIdx
    //insertUserExternalService
    ////일반 uSER가 가능한 외부 서비스 목록에서 외부 서비스 등록
    //router.post("/:externalIdx", authUtil.isLoggedin, async(req, res)=>{
    //    const {externalIdx} = req.params;
    //    const userIdx = req.decoded.user_idx;
/*    @PostMapping(path="/{externalIdx}")
    public simpleResponse insertUserExternalService(@PathVariable("externalIdx") int externalIdx){
        return externalServiceService.insertUserExternalService()
    }
*/
}



/*



        //getUserExternalServiceByUserIdx
        @GetMapping


//    getUserExternalServiceDetailByUserIdxAndExternalServiceIdx
        @GetMapping(path="/detail/{externalIdx}")




//deleteUserExternalService
        @DeleteMapping("/{externalIdx}")

        //updateUserExternalServiceDetail
        @PutMapping(path="/{externalIdx}/{externalDetailIdx}")

 */


