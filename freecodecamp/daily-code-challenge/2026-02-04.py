def truncate_text(text):
    return text if len(text) <= 20 else text[:17] + "..."
