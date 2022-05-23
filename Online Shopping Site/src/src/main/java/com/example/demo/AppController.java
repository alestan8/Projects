package com.example.demo;


import com.example.demo.comenzi.Comanda;
import com.example.demo.comenzi.ComandaFromDatabase;
import com.example.demo.produse.Produs;
import com.example.demo.produse.ProdusFromDatabase;
import com.example.demo.user.User;
import com.example.demo.user.UserModifyInDataBase;
import com.example.demo.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Controller
    public class AppController {

        @Autowired
        private UserRepository userRepo;


        @GetMapping("")
        public String viewHomePage() {
            return "home";
        }

    @GetMapping("/admin")
    public String listUsers(Model model) throws SQLException {
        List<User> listUsers = userRepo.findAll();
        model.addAttribute("listUsers", listUsers);

        ProdusFromDatabase p=new ProdusFromDatabase();
        List<Produs> listProd=p.vizualizareProduse();
        model.addAttribute("listProd",listProd);

        ComandaFromDatabase c=new ComandaFromDatabase();
        List<Comanda> listCo=c.vizualizareComenzi();
        model.addAttribute("listCo",listCo);

        return "administrator";
    }

    @GetMapping("/home")
    public String goHomeL(Model model){
            model.addAttribute("user",new User());
        return "home2";
    }

        @GetMapping("/Register")
        public String Register(Model model){
            model.addAttribute("user", new User());
            return "register";}
        @PostMapping("/homeR")
        public String goHomeR(User user){
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
            user.setRole("ROLE_CLIENT");
            userRepo.save(user);
            return "home";
        }
    @RequestMapping("/client/{id}")
    public  ModelAndView showUser(@PathVariable(name = "id") Long id) throws SQLException {
        ModelAndView mav = new ModelAndView("client");
        User user = userRepo.findByID(id);
        ComandaFromDatabase c=new ComandaFromDatabase();
        List<Comanda> comenzi=c.vizualizareComenziClient(id);
        mav.addObject("user", user);
        mav.addObject("listCo",comenzi);
        return mav;
    }
    @Transactional
    @PostMapping( "/saveu")
    public String saveUser(@ModelAttribute("user") User user) throws SQLException {
     //  UserModifyInDataBase um=new UserModifyInDataBase();
       // um.updateUser(user);
        userRepo.updateUser(user.getLastName(),user.getFirstName(),user.getRole(), user.getEmail());
        return "home2";
    }
    @Transactional
    @RequestMapping("/delete/{email}")
    public String deleteUser(@PathVariable(name = "email") String email)  throws SQLException {
        //  UserModifyInDataBase um=new UserModifyInDataBase();
        // um.updateUser(user);
        //System.out.println(email);
        userRepo.deleteUser(email);
        return "deleted2";
    }
    @GetMapping("/provider")
    public String goToProvider(Model model){
            model.addAttribute("produs", new Produs());
            return "providerPage";
    }
    @PostMapping("/homeFromProvider")
    public String goHomeP(Produs produs) throws SQLException {
            ProdusFromDatabase p=new ProdusFromDatabase();
            if(p.verificareExistentaProdus(produs)==true){
                int cant=p.cantitateProdus(produs);
                int cant2= produs.getQuantity();
                produs.setQuantity(cant+cant2);
                p.updateProdus(produs);
            }
            else{
                p.insertProdus(produs);
            }
            return "home2";
    }
    @GetMapping("/newUser")
    public String createNewUser(Model model){
            model.addAttribute("user",new User());
            return "newClient";
    }
    @PostMapping("/saveNewUser")
    public String saveNewUSer(User user){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepo.save(user);
        return "home2";
    }
    @RequestMapping("/myAccount/{email}")
    public  ModelAndView showMyUser(@PathVariable(name = "email") String email) throws SQLException {
        ModelAndView mav = new ModelAndView("myAccount");
        User user = userRepo.findByEmail(email);
        ComandaFromDatabase c=new ComandaFromDatabase();
        List<Comanda> comenzi=c.vizualizareComenziClient(user.getId());
        mav.addObject("user", user);
        mav.addObject("listCo",comenzi);
        return mav;
    }
    @Transactional
    @PostMapping( "/savemy")
    public String saveMyUser(@ModelAttribute("user") User user) throws SQLException {
        //  UserModifyInDataBase um=new UserModifyInDataBase();
        // um.updateUser(user);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        userRepo.updateUserPass(user.getLastName(),user.getFirstName(),user.getRole(),encodedPassword,user.getAddress(), user.getEmail());
        return "home2";
    }
    @Transactional
    @RequestMapping("/deletemy/{email}")
    public String deleteMyUser(@PathVariable(name = "email") String email)  throws SQLException {
        //  UserModifyInDataBase um=new UserModifyInDataBase();
        // um.updateUser(user);
        //System.out.println(email);
        userRepo.deleteUser(email);
        return "deleted";
    }
    @GetMapping("/deleted")
    public String deleted(){
            return "deleted";
    }
    @GetMapping("/produs")
    public String goProdus(Model model){
            Produs p=new Produs();
            p.setName("merge");
            p.setImage1("p2.jpg");
            p.setImage2("p3.jpg");
            p.setImage3("p4.jpg");
            model.addAttribute("produs",p);

            return "Produs";
    }

    @RequestMapping("/produs/{id}")
    public  ModelAndView showProdus(@PathVariable(name = "id") Long id) throws SQLException {
        ModelAndView mav = new ModelAndView("Produs");
        ProdusFromDatabase pr=new ProdusFromDatabase();
        Produs p=pr.vizualizareProdus(id);
        mav.addObject("produs", p);
        return mav;
    }
    @Transactional
    @GetMapping ( "/adaugareP")
    public String adaugarePr( Produs produs) throws SQLException {
        //adaugare in lista de cumparaturi
        System.out.println("s-a adaugat");
        return "home2";
    }
}


