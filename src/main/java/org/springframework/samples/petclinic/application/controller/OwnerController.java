package org.springframework.samples.petclinic.application.controller;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.samples.petclinic.application.dto.owner.OwnerReques;
import org.springframework.samples.petclinic.application.dto.owner.OwnerRequest;
import org.springframework.samples.petclinic.application.dto.owner.OwnerResponse;
import org.springframework.samples.petclinic.application.mapper.OwnerDtoMapper;
import org.springframework.samples.petclinic.domain.model.Owner;
import org.springframework.samples.petclinic.domain.service.interfaces.OwnerServiceCreate;
import org.springframework.samples.petclinic.domain.service.interfaces.OwnerServiceFind;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Objects;

@Controller
public class OwnerController {

	private static final String VIEWS_OWNER_CREATE_OR_UPDATE_FORM = "owners/createOrUpdateOwnerForm";

//	private final OwnerRepository owners;

	private final OwnerServiceCreate ownerServiceCreate;
	private final OwnerServiceFind ownerServiceFind;
	private final OwnerDtoMapper ownerDtoMapper;

	public OwnerController(OwnerServiceCreate ownerServiceCreate, OwnerServiceFind ownerServiceFind, OwnerDtoMapper ownerDtoMapper) {
		this.ownerServiceCreate = ownerServiceCreate;
		this.ownerServiceFind = ownerServiceFind;
		this.ownerDtoMapper = ownerDtoMapper;
	}

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@ModelAttribute("owner")
	public OwnerResponse findOwner(@PathVariable(name = "ownerId", required = false) Integer ownerId, Model model) {

		if(Objects.isNull(ownerId)){
			return OwnerResponse.builder().build();
		}

		try {
//			model.addAttribute("id",ownerId);
			return ownerDtoMapper.toResponse(
				ownerServiceFind.findOwnerById(ownerId)
			);
		}catch (IllegalArgumentException e){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Owner not found with id: " + ownerId + ". Please ensure the ID is correct "
					+ "and the owner exists in the database."
			);
		}
//		return ownerId == null ? new OwnerResponse()
//			: this.owners.findById(ownerId)
//			.orElseThrow(() -> new IllegalArgumentException("Owner not found with id: " + ownerId
//				+ ". Please ensure the ID is correct " + "and the owner exists in the database."));
	}

	@GetMapping("/owners/new")
	public String initCreationForm() {
		return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
	}

	@PostMapping("/owners/new")
	public String processCreationForm(@Valid OwnerRequest request, BindingResult result, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			redirectAttributes.addFlashAttribute("error", "There was an error in creating the owner.");
			return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
		}

		Owner owner = ownerDtoMapper.toModel(request);
		ownerServiceCreate.saveOwner(owner);

//		this.owners.save(owner);
		redirectAttributes.addFlashAttribute("message", "New Owner Created");
		return "redirect:/owners/" + owner.getId();
	}

	@GetMapping("/owners/find")
	public String initFindForm() {
		return "owners/findOwners";
	}

	@GetMapping("/owners")
	public String processFindForm(@RequestParam(defaultValue = "1") int page, String LastName,
								  Model model)
	 {
		// allow parameterless GET request for /owners to return all records
		if (LastName == null) {
			LastName = ""; // empty string signifies broadest possible search
		}

		// find owners by last name
		Page<Owner> ownersResults = ownerServiceFind.findByLastNameStartingWith(LastName,page);

		if (ownersResults.isEmpty()) {
			// no owners found
//			result.rejectValue("lastName", "notFound", "not found");
			return "owners/findOwners";
		}

		if (ownersResults.getTotalElements() == 1) {
			// 1 owner found
			Owner owner = ownersResults.iterator().next();

//			return "redirect:/owners/" + owner.getId();
			return "redirect:/owners/" + owner.getId();
		}

		// multiple owners found
		return addPaginationModel(page, model, ownersResults);
	}

	private String addPaginationModel(int page, Model model, Page<Owner> paginated) {
//		List<Owner> listOwners = paginated.getContent();
		Page<OwnerResponse> responses = ownerDtoMapper.toResponsePage(paginated);

		List<OwnerResponse> listOwners = responses.getContent();

		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", paginated.getTotalPages());
		model.addAttribute("totalItems", paginated.getTotalElements());
		model.addAttribute("listOwners", listOwners);
		return "owners/ownersList";
	}

//	private Page<Owner> findPaginatedForOwnersLastName(int page, String lastName) {
//		int pageSize = 5;
//		Pageable pageable = PageRequest.of(page - 1, pageSize);
//		return owners.findByLastNameStartingWith(lastname, pageable);
//	}

	@GetMapping("/owners/{ownerId}/edit")
	public String initUpdateOwnerForm(@PathVariable("ownerId") int ownerId, Model model) {
		OwnerResponse response = ownerDtoMapper.toResponse(
			ownerServiceFind.findOwnerById(ownerId)
		);
		model.addAttribute("isNew",false);
		model.addAttribute("owner",response);

		return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
	}

	@PostMapping("/owners/{ownerId}/edit")
	public String processUpdateOwnerForm(@Valid @ModelAttribute("OwnerRequest") OwnerReques request, BindingResult result, @PathVariable("ownerId") int ownerId,
										 RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			redirectAttributes.addFlashAttribute("error", "There was an error in updating the owner.");
			return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
		}

		try {

//			if(request.getId() != ownerId){
//				result.rejectValue("id", "mismatch", "The owner ID in the form does not match the URL.");
//				redirectAttributes.addFlashAttribute("error", "Owner ID mismatch. Please try again.");
//				return "redirect:/owners/{ownerId}/edit";
//			}

//			var ownerTmp = ownerServiceFind.findOwnerById(ownerId);
//			if (Objects.nonNull(ownerTmp)){
//
//			}

			ownerServiceCreate.updateOwner(
				ownerDtoMapper.toModel(request),
				ownerId
			);

			redirectAttributes.addFlashAttribute("message", "Owner Values Updated");
			return "redirect:/owners/{ownerId}";


		}catch (IllegalArgumentException e){
			result.rejectValue("id", "mismatch", "The owner ID in the form does not match the URL.");
			redirectAttributes.addFlashAttribute("error", "Owner ID mismatch. Please try again.");
//			return "redirect:/owners/{ownerId}/edit";
		}

//		if (request.getId() != ownerId) {
//			result.rejectValue("id", "mismatch", "The owner ID in the form does not match the URL.");
//			redirectAttributes.addFlashAttribute("error", "Owner ID mismatch. Please try again.");
//			return "redirect:/owners/{ownerId}/edit";
//		}
//
//		owner.setId(ownerId);
//		this.owners.save(owner);
//		redirectAttributes.addFlashAttribute("message", "Owner Values Updated");
//		return "redirect:/owners/{ownerId}";
		return "";
	}

//	/**
//	 * Custom handler for displaying an owner.
//	 * @param ownerId the ID of the owner to display
//	 * @return a ModelMap with the model attributes for the view
//	 */
	@GetMapping("/owners/{ownerId}")
	public ModelAndView showOwner(@PathVariable("ownerId") int ownerId) {
		ModelAndView mav = new ModelAndView("owners/ownerDetails");
		OwnerResponse response;
		try {
			response = ownerDtoMapper.toResponse(ownerServiceFind.findOwnerById(ownerId));
			mav.addObject(response);

		}catch (IllegalArgumentException e){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Owner not found with id: " + ownerId + ". Please ensure the ID is correct "
				);
		}

//		Optional<Owner> optionalOwner = this.owners.findById(ownerId);
//		Owner owner = optionalOwner.orElseThrow(() -> new IllegalArgumentException(
//			"Owner not found with id: " + ownerId + ". Please ensure the ID is correct "));
//		mav.addObject(owner);
		return mav;
	}

}
