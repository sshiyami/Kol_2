package org.example;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Fib {
    public static class RestRes
    {

        private int num;

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public int Fib1(int num)
        {
            if(num <=1)
                return 0;

            if(num == 2)
                return 1;

            return Fib1(num -1)+Fib1(num-2);
        }

    }

    @RequestMapping(value = "/fib/{num}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RestRes> restMethod(@PathVariable int num)
    {
        RestRes result = new RestRes();

        result.Fib1(num);
        result.getNum();
        result.toString();
        result.setNum(num);


        return ResponseEntity.ok(result);
    }

}