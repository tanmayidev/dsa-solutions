def get_element_size(window_size, element_vw, element_vh):
    # Extract window width and height
    w, h = map(int, window_size.split(" x "))
    
    # Extract percentage values
    vw_percent = float(element_vw.replace("vw", ""))
    vh_percent = float(element_vh.replace("vh", ""))
    
    # Calculate pixel sizes
    element_width = int(w * vw_percent / 100)
    element_height = int(h * vh_percent / 100)
    
    return f"{element_width} x {element_height}"
